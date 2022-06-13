const express = require('express');
const User = require('../models/User');
const BadRequestError = require('../errors/bad-request-error');

const signoutRouter = express.Router();

signoutRouter.post('/auth/signout', async (req, res) => {
    /**Not implemented: isRevoked*/
    res.send('signout');
});

module.exports = signoutRouter;