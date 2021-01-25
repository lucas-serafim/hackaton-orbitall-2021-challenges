const api = require('../controllers/card-controller')

module.exports = (app) => {
    app.route('/cards')
        .get(api.findAll)
        .post(api.insert)

   app.route('/cards/:id')
         .put(api.update)
         .delete(api.remove)
         .get(api.findById)
}