const express = require('express');
const User = require('../models/User');
const { body, validationResult } = require('express-validator');
const BadRequestError =  require('../errors/bad-request-error');

const signupRouter = express.Router();

signupRouter.post('/auth/signup',[
    body("username").isString().not().isEmpty().withMessage("Username must not be empty"),
    body("email").isEmail().withMessage("Email is invalid"),
    body("password").isLength({ min: 5, max: 20 })
], async (req, res, next) => {
    const { errors } = validationResult(req);
    if (errors.length > 0) {
        next(new BadRequestError("Invalid inputs", errors));
        return;
    }
    const { email, username, password } = req.body;
    const user = new User({ username, email });
    user.setPassword(password);
    try {
        await user.save();
    } catch(err) {
        next(err);
        return;
    }
    
    const userDto = user.toAuthJSON();    
    return res.status(200).send(JSON.stringify(userDto));
});

module.exports = signupRouter;