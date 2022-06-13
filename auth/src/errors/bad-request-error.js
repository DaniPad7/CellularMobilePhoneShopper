const CustomError = require("./custom-error");


class BadRequestError extends CustomError {
    constructor(message, errors) {
        super(message, "BadRequestError", 400);
        this.errors = errors;
        Object.setPrototypeOf(this, BadRequestError.prototype);
    }
}

module.exports = BadRequestError;