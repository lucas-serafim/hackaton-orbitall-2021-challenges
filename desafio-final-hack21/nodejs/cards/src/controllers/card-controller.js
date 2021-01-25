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
   const body = request.body

   neDB.insert(body, (exception, card) => {
      if (exception) {
         messageError = { message: exception }
         response.json(messageError)
         response.status(exception.status | 501)
      }

      response.status(201).json(card)
   })
}

api.update = (request, response) => {
   const id = request.params.id
   const body = request.body

   neDB.update({ _id: id }, body, (exception, hadUpdated) => {
      if (exception) {
         messageError = { message: exception }
         response.json(messageError)
         response.status(exception.status | 501)
      }

      if (hadUpdated) {
         body._id = id
         response.json(body)
      } else {
         messageError = { message: exception }
         response.json(messageError)
         response.status(exception.status | 501)
      }
   })
}

api.remove = (request, response) => {
   const id = request.params.id

   neDB.remove({ _id: id }, {}, (exception, hadDeleted) => {
      if (exception) {
         messageError = { message: exception }
         response.json(messageError)
         response.status(exception.status | 501)
      }

      if (hadDeleted) {
         response.status(200).json({ 'message': `Card ID:(${id}) has been deleted` })
      }
   })
}

api.findById = (request, response) => {

}

module.exports = api