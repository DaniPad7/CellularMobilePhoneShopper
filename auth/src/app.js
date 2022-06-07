const express = require('express');
const { expressjwt: jwtValidator } = require('express-jwt');
const CustomError = require('./errors/custom-error');
const signinRouter = require('./routes/signin');
const secret = require('./services/password-service');

const app = express();

app.use(jwtValidator({
    secret: secret,
    algorithms: ["HS256"]
}).unless({ path: ["/auth/signin"] }));

app.use(signinRouter);

app.get('/', (req, res) => {
    res.send('This will dispatch and verify jwt for authn and authz');
});

const errorHandler = (err, req, res, next) => {
    if (err.name === "UnauthorizedError") {
        console.error(err);
        return res.status(401).send({ errors: [{ message: err.message }] });
    }
    if (err instanceof CustomError) {
        return res.status(err.status).send({ errors: err.serializeErros() });
    }
    console.error(err);
    res.status(400).send({ errors: [{ message: err.message }] });
};

app.use(errorHandler);
module.exports = app;
