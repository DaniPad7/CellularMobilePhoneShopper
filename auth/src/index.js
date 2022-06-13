const mongoose = require('mongoose');
const app = require('./app');

const start = async () => {
    try {
        mongoose.connect(process.env.MONGO_URI);
        console.log('Connected to auth-mongodb AND HELLO ITS NEW ME');
    } catch (err) {
        console.log(err);
    }
    app.listen(3000, () => console.log('Auth app has started!'));
};
start();