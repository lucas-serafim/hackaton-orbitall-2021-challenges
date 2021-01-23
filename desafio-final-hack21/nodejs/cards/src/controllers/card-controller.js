const neDB = require('../configurations/database')
const api = {}

api.findAll = (request, response) => {
   neDB.find({}).exec((exception, cards) => {
      if (exception) {
         response.status(exception.status | 400)
         response.json({ 'Message': "Error"})
      }
      response.status(200)
      response.json(cards)
   })
}

api.insert = (request, response) => {
   const canonical = request.body

   neDB.insert(canonical, (exception, cards) => {
      if (exception) {
         response.status(exception.status | 400)
         response.json({ 'Message': "Error"})
      }

      response.status(201)
      response.json(cards)
   })
}

api.update = (request, response) => {
   neDB.update({ _id: request.params.id }, (exception, cards) => {
      if (exception) {
         response.status(exception.status | 400)
         response.json({ 'Message': "Error"})
      }

      response.status(200)
   })
}

api.remove = (request, response) => {
   neDB.remove({  _id: request.params.id }, (exception, cards) => {
      if (exception) {
         response.status(exception.status | 400)
         response.json({ 'Message': "Error"})
      }

      response.status(200)
   })
}

api.findById = (request, response) => {
   neDB.findOne({ _id: request.params.id }, (exception, cards) => {
      if (exception) {
         response.status(exception.status | 400)
         response.json({ 'Message': "Error"})
      }

      response.status(200)
      response.json(cards)
   })
}

module.exports = api