const express = require('express');
const { expressjwt: jwtValidator } = require('express-jwt');
const CustomError = require('./errors/custom-error');
const NotFoundError = require('./errors/not-found-error');
const signinRouter = require('./routes/signin');
const signupRouter = require('./routes/signup');
const secret = require('./services/password-service');

const app = express();

app.use(express.json({ type: 'application/json' }));

app.use(jwtValidator({
    secret: secret,
    algorithms: ["HS256"],
    issuer: "http://localhost:3000"
}).unless({ path: ["/auth/signup", "/auth/signin"] }));

app.use(signinRouter);
app.use(signupRouter);

app.all('*', (req, res) => {
    throw new NotFoundError([{ location: "undefined", param: "undefined", msg: "Resource Not Found" }]);
});

const errorHandler = (err, req, res, next) => {
    if (err.name === "UnauthorizedError") {
        return res.status(401).send({ errors: [{ location: 'auth', param: 'auth', msg: err.message }] });
    }
    if (err instanceof CustomError) {
        return res.status(err.statusCode).send({ errors: err.errors });
    }
    console.error("Hey I am all here!! : ", err);
    return res.status(400).send({ errors: [{ location: "auth", param: "" , msg: err.message 
    || "Oops Something Went Wrong" }] });
};

app.use(errorHandler);
module.exports = app;
