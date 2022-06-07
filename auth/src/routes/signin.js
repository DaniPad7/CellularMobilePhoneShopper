const express = require('express');
const User =  require('../models/User');
const BadRequestError = require('../errors/bad-request-error');

const signinRouter = express.Router();

signinRouter.post('/auth/signin', async (req, res) => {
    const { email, username, password } = req.body;
    if (!email) {

    }
    if (!password) {

    }
    if (!username) {

    }
    const persistedUser = await User.findOne(email || username);
    if (!persistedUser) {
        throw new BadRequestError("User not found in the db.");
    }
    if (!persistedUser.isValidPassword()) {
        throw new BadRequestError("Password is invalid.");
    }
    const userDto = persistedUser.toAuthJSON();
    return res.status(200).send(JSON.stringify(userDto));
});

module.exports = signinRouter;

