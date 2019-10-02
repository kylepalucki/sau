var cashRegister = {
    total : 0,
    item : 0,
    add : function(itemCost) {
        this.total += itemCost;
    }
};

function scan()  {
    var t = parseInt(window.prompt("Enter total number of items"));
    for (i=0; i<t; i++){
        var c = parseFloat(window.prompt("Enter item cost"));
        cashRegister.add(c);
    }
}

function print() {
    document.writeln(cashRegister.total<=0? "Please enter your items cost first" : "Your total is $"+cashRegister.total.toFixed(2));
}