const express = require('express');
const User = require('../models/User');
const BadRequestError = require('../errors/bad-request-error');

const signupRouter = express.Router();

signupRouter.post('/auth/signup', async (req, res) => {
    const { email, username, password } = req.body;
    if (!email) {

    }
    if (!password) {

    }
    if (!username) {

    }
    /**UniqueValidator plugin is already in UserSchema */
    // const persistedUser = await User.findOne(email);
    // if (persistedUser) {
    //     throw new BadRequestError("Email is already in use.");
    // }
    const user = new User({ username, email });
    user.setPassword(password);
    await user.save();
    
    const userDto = persistedUser.toAuthJSON();    
    return res.status(200).send(JSON.stringify(userDto));
});

module.exports = signupRouter;