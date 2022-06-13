const CustomError = require("./custom-error");


class NotFoundError extends CustomError {
    constructor(message, errors) {
        super(message, "NotFoundError", 404);
        this.errors = errors;
        Object.setPrototypeOf(this, NotFoundError.prototype);
    }
}

module.exports = NotFoundError;