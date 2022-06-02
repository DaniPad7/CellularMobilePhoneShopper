const crypto = require('crypto');

const secret = crypto.randomBytes(16).toString('hex') + Math.random() * 999999;

module.exports = secret;