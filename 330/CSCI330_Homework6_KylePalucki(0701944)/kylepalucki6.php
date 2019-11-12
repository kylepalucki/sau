<html>
<!--kyle palucki hw 6-->
<body>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">
  Operand 1: <input type="text" name="op1"> * <br>
  Operand 2: <input type="text" name="op2"> * <br>
  <select name="operation">
   <option value="add"> + </option>
   <option value="sub"> - </option>
   <option value="mult"> * </option>
   <option value="div"> / </option>
  </select>
  <br>
  <input type="submit">
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $op1 = $_POST['op1'];
	$op2 = $_POST['op2'];
	$operation = $_POST['operation'];
	if (is_numeric($op1) && is_numeric($op2)) {
		$ans=0;
		$o='';
		if ($operation == 'add'){
			$ans=$op1+$op2;
			$o='+';
		} else if ($operation == 'sub'){
			$ans=$op1-$op2;
			$o='-';
		} else if ($operation == 'mult'){
			$ans=$op1*$op2;
			$o='*';
		} else if ($operation == 'div'){
			$ans=$op1/$op2;
			$o='/';
		}
		echo $op1 . $o . $op2 . "=" . $ans;
	} else {
		echo "non-numeric input";
	}
	echo "<br>";
}

?>

</body>
</html>