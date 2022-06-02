const express = require('express');

const app = express();

app.get('/', (req, res) => {
    res.send('This will dispatch and verify jwt for authn and authz');
});

module.exports = app;
