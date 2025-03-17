function matchPassword()
{
    if(document.getElementById('rpassword').value!=document.getElementById('password').value)
    {
	  alert("Confirm Password does not match with Password")
	  return false;
    }
    return true;
}
function findCost()
{
   var total=document.getElementById("price").innerHTML*document.getElementById("quantity").value;
   document.getElementById("cost").innerHTML=total;
}
function checkQuantity()
{
	var rq=parseInt(document.getElementById("quantity").value);
	if(rq<1 || rq>document.getElementById("aq").innerHTML)
	{
		alert("Quantity can not be more than Available Quantity");
		document.getElementById("quantity").value=1;
	}
 }
