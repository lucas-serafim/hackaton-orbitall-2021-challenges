const neDB = require('../configurations/database')
const api = {}

api.findAll = (request, response) => {
   neDB.find({}).sort({ name: 1 }).exec((exception, cards) => {
      if (exception) {
         messageError = { message: exception }
         response.json(messageError)
         response.status(exception.status | 501)
      }

      response.json(cards)
   })
}

api.insert = (request, response) => {
   
}

api.update = (request, response) => {
   
}

api.remove = (request, response) => {
   
}

api.findById = (request, response) => {

}

module.exports = api