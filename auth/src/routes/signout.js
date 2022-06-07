const express = require('express');
const User = require('../models/User');
const BadRequestError = require('../errors/bad-request-error');

const signoutRouter = express.Router();

signoutRouter.post('/auth/signout', async (req, res) => {
    /**Not implemented */
    const { email, password } = req.body;
    if (!email) {

    }
    if (!password) {

    }
    const persistedUser = await User.findOne(email);
    if (!persistedUser) {
        throw new BadRequestError("User not found in the db.");
    }
    if (!persistedUser.isValidPassword()) {
        throw new BadRequestError("Password is invalid.");
    }
    const userDto = persistedUser.toAuthJSON();    
    return res.status(200).send(JSON.stringify(userDto));

});

module.exports = signoutRouter;