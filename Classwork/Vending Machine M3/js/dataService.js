var DataService = function() {
  var self = this;

  self.Item1 = function(itemId, callback, onError) {

  }
  self.makePurchase = function(cashAmount, itemId, callback, onError) {
    $.ajax({
      url: 'http://tsg-vending.herokuapp.com/money/' + cashAmount + '/item/' + itemId,
      method: 'POST',
      success: callback,
      error: onError
    });

  }

  self.getAllItems = function(callback, onError) {
    $.ajax({
      url: 'http://tsg-vending.herokuapp.com/items',
      method: 'GET',
      success: callback,
      error: onError
    })
  }
}
