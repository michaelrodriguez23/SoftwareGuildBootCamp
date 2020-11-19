var ds = new DataService();
var moneyIn = 0.0;
var globalId= 0;

// JSON to Jquerty

function refreshMenu(items) {
$("#cash-in-system").val("$0.00");

  //$('#cash-input-form').trigger("reset");
  $('#message-purchase-form').trigger("reset");
  $("#menu").empty();
  for (var i = 0; i < items.length; i++) {
    let currentItem = items[i];
    let itemFormat = `

  <a href="#" data-itemId ="${items[i].id}" class= "box">
    <div class="myRow col-md-3>
          <table width ="400px" cellpadding="20px">

          <tr class="data-cell">
          <td>
          <p class="text-left">${items[i].id}</p>
          </td>
          </tr>
          <tr class="data-cell">
          <td>
          <p class ="text-center">${items[i].name}</p>
          </td>
          </tr>
          <tr class="data-cell">
          <td>
          <p class="text-center">$ ${items[i].price.toFixed(2)}</p>
          </td>
          </tr>
          <tr class="data-cell">
          <td>
          <p class="text-center">Quantity Left: ${items[i].quantity}</p>
          </td>
          </tr>
          </table>


        </div>
        </a>`;
    $("#menu").append(itemFormat);
// seperate the format to its own function
// html write the static grid and just adding the grid items

  }

}
//functions that interact with your page
function updateMoney(message) {
  let cashInput = $("#cash-in-system");
  cashInput.val(message);
}

function updateListOfItems(itemList) {
  let items = itemList;
}

//functions for your on clicks
function onAddDollarClicked(e) {
    e.preventDefault();
  //alert("Added a dollar");
  moneyIn += 1;
  updateMoney(moneyIn.toFixed(2));
}

function onAddQuarterClicked(e) {
    e.preventDefault();
  //alert("Added a quarter");
  moneyIn += 0.25;
  updateMoney(moneyIn.toFixed(2));
}

function onAddDimeClicked(e) {
    e.preventDefault();
  moneyIn += 0.10;
  updateMoney(moneyIn.toFixed(2));
}

function onAddNickleClicked(e) {
    e.preventDefault();
  moneyIn += 0.05;
  updateMoney(moneyIn.toFixed(2));
}

function onMakePurchaseClicked(e) {
      e.preventDefault();
  let cashAmount = moneyIn;
  $("#item-number").val(globalId);
ds.makePurchase(cashAmount,globalId,refreshForm, alertError);


}

function alertError(msg) {
$("#message-text").val(msg.responseText);
}

function refreshForm(change){
$("#message-text").val("Thank You");
};

function onItemClicked(e) {
  e.preventDefault();
  $("#cash-in-system").val("$0.00");
  $("#item-number").val(" ");
  $("#message-text").val(" ");
  $("#change-returned").val(" ");


  let itemId = $(this).attr('data-itemId');
  globalId = itemId;
  $("#item-number").val(itemId);
};

function refreshChange(change) {
$("#change-returned").val(`Quarters :  ${change.quarters}
 Dimes :   ${change.dimes}  Nickels :  ${change.nickels}  Pennies :   ${change.pennies}  `);
};



function onReturnChangeClicked(e){
  e.preventDefault();
  let cashAmount = moneyIn;
  $("#item-number").val(globalId);
ds.makePurchase(cashAmount,globalId,refreshChange, alertError);

};



//Page setup
$(document).ready(function() {
  $("#change-returned").val("");
  ds.getAllItems(refreshMenu);
  //Wire up all your on clicks
  $(document).on('click', '#add-dollar', onAddDollarClicked);
  $(document).on('click', '#add-quarter', onAddQuarterClicked);
  $(document).on('click', '#add-dime', onAddDimeClicked);
  $(document).on('click', '#add-nickle', onAddNickleClicked);
  $(document).on('click', '#make-purchase', onMakePurchaseClicked);
  $(document).on('click',  '#change-return-button', onReturnChangeClicked);
  $(document).on('click', 'a', onItemClicked);

});
