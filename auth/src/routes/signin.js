const express = require('express');
const User =  require('../models/User');
const BadRequestError = require('../errors/bad-request-error');
const { body, validationResult } = require('express-validator');

const signinRouter = express.Router();

signinRouter.post('/auth/signin',[
    body("username").isString().not().isEmpty().optional({checkFalsy: true})
    .withMessage("Username must not be empty"),
    body("email").isEmail().optional({ checkFalsy: true }).withMessage("Email is invalid"),
    body("password").isLength({ min: 5, max: 20 })
], async (req, res, next) => {
    const { errors } = validationResult(req);
    if (errors.length > 0) {
        next(new BadRequestError("Invalid inputs", errors));
        return;
    }
    const { email, username, password } = req.body;
    /**UniqueValidator plugin is already in UserSchema */
    if (!email && !username) {
        next(new BadRequestError("No identifier provided.", [
            { location: "auth", param: "undefined", msg: "No identifier provided" }
        ]));
        return;
    }
    const filter = email ? { email } : { username };
    const persistedUser = await User.findOne(filter);
    if (!persistedUser) {
        next(new BadRequestError("User not found in the db.", [
            { location: "auth", param: "undefined", msg: "User not found in DB" }
        ]));
        return;
    }
    if (!persistedUser.isValidPassword(password)) {
        next(new BadRequestError("Password is invalid.", [
            { location: "auth", param: "password", msg: "Password is invalid" }
        ]));
        return;
    }
    const userDto = persistedUser.toAuthJSON();
    return res.status(200).send(JSON.stringify(userDto));
});

module.exports = signinRouter;

