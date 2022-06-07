const mongoose = require('mongoose');
const uniqueValidator = require('mongoose-unique-validator');
const crypto = require('crypto');
const secret = require('../services/password-service');
const jwt = require('jsonwebtoken');

const UserSchema = new mongoose.Schema({
    username: {
        type: String,
        lowercase: true,
        required: true,
        index: true,
        unique: true
    },
    email: {
        type: String,
        lowercase: true,
        required: true,
        index: true,
        unique: true
    },
    hash: {
        type: String,
        lowercase: true,
        required: true
    },
    salt: {
        type: String,
        lowercase: true,
        required: true
    },
}, { timestamps: true});

/**Test arrow function first, change to annonymous function if needed
 * Continue here with express-jwt npm package
 */
UserSchema.methods.setPassword = (password) => {
    this.salt = crypto.randomBytes(16).toString('hex');
    this.hash = crypto.pbkdf2Sync(password, this.salt, 100, 64, 'sha512').toString('hex');
};
UserSchema.methods.isValidPassword = (password) => {
    const restored = crypto.pbkdf2Sync(password, this.salt, 100, 64, 'sha512').toString('hex');
    return this.hash === restored;
};
UserSchema.methods.generateJwt = () => {
    const expire = new Date(new Date().getSeconds() + 120);
    return jwt.sign({ id: this._id, username: this.username }, secret,
        { expiresIn: expire.getSeconds() - new Date().getSeconds(), issuer: "http://localhost:3000" });
};
UserSchema.methods.toAuthJSON = () => {
    return {
        username: this.username,
        // email: this.email,
        token: this.generateJwt(),
    };
};

UserSchema.plugin(uniqueValidator, { message: "Field is already taken" });

const User = mongoose.model("User", UserSchema);

module.exports = User;