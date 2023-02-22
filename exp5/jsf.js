function ck()
{
    let a = document.forms["mfs"]["nm"].value;
    if(a == "")
    {        
        document.getElementById("w1").innerHTML = "Enter a proper valid Name";
        return false;
    }
    let b = document.forms["mfs"]["ad"].value;
    if(b == "")
    {        
        document.getElementById("w2").innerHTML = "Enter Proper Address";
        return false;
    }
    let c = document.forms["mfs"]["cd"].value;
    if(c == "")
    {        
        document.getElementById("w3").innerHTML = "Enter a proper valid Zip Code";
        return false;
    }
    let d = document.forms["mfs"]["ph"].value;
    if(d == "")
    {        
        document.getElementById("w7").innerHTML = "Enter Proper Mobile Number";
        return false;
    }
    let e = document.forms["mfs"]["em"].value;
    if(e == "")
    {        
        document.getElementById("w8").innerHTML = "Enter a proper valid E-Mail";
        return false;
    }
    let f = document.forms["mfs"]["ps"].value;
    if(f == "")
    {        
        document.getElementById("w9").innerHTML = "Enter Proper Password";
        return false;
    }
}
