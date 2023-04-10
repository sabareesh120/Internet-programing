<?php
$sname = "localhost";
$uname = "root";
$pword = "";
$dbname = "exlv";

//$c = new mysqli($sname,$uname,$pword);
$c = new mysqli($sname,$uname,$pword,$dbname);

if($c->connect_error)
{
	echo "We are so Sorry, DB not connected";
}
else
{
	echo "The Connection done";
}

$sql = "drop database exlv";
$sql1 = "create database exlv";
//echo "<br> The DB Created";
/*
if($c->query($sql1)===true)
{
	echo "<br>The DB Created<br>";
}
else
{
	echo "<br>We are so Sorry to say that, DB not Created";
}
$sql2 = "create table contacts(name varchar(50),email varchar(50),Data varchar(200))";
//$sql2 = "drop table contacts";
if($c->query($sql2)===true)
{
	echo "<br>New Table has been created.<br>";
}
else
{
	echo "<br>Sorry bro, Something happend.";
}
*/
//echo "<br>New Table has been created.<br>";
$nm = $_POST['gnm'];
$em = $_POST['ems'];
$st = $_POST['msg'];

$sto = "insert into contacts values('".$nm."','".$em."','".$st."')";

if($c->query($sto)===true)
{
	echo "<br>All your data's has been saved in the DB,herafter there is no needs of Worring.";
}
?>
