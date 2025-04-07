function findCost() {
    const total = document.getElementById("price").innerHTML * document.getElementById("quantity").value;
    document.getElementById("cost").innerHTML = total;
}

function checkQuantity() {
    const rq = parseInt(document.getElementById("quantity").value);
    const aq = parseInt(document.getElementById("aq").innerHTML);

    if (rq < 1 || rq > aq) {
        alert("Entered quantity can't be more than available quantity!");
        document.getElementById("quantity").value = 1;
        findCost();
    }
}
