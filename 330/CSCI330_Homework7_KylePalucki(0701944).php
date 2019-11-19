<html>
<!--Kyle Palucki hw 7-->
<head>
<title>STUDENTS</title>
</head>
<body>


<?php
$conn = new mysqli("localhost", "root", "", "csci330");

if ($conn->connect_error) {
	die("Connection Failed: " . $conn->connect_error);
} else {
	echo "Connection Established";
}
echo"<br>";
echo"<br>";

$sql_male_students = 'SELECT * FROM students WHERE Gender="Male";';
$result = mysqli_query($conn, $sql_male_students);
if ($result) $query = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo "<b>Male students:</b> "; 
print_r($query);

echo"<br>";
echo"<br>";

$sql_students_over_21 = 'SELECT * FROM students WHERE Age>21;';
$result = mysqli_query($conn, $sql_students_over_21);
if ($result) $query = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo "<b>Students over 21:</b> ";
print_r($query);

echo"<br>";
echo"<br>";

$sql_no_phone = 'SELECT * FROM students WHERE Phone IS NULL;';
$result = mysqli_query($conn, $sql_no_phone);
if ($result) $query = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo "<b>Students with no phone number entry:</b> ";
print_r($query);

echo"<br>";
echo"<br>";

$sql_major_count = 'SELECT DISTINCT COUNT(Major) FROM students;';
$result = mysqli_query($conn, $sql_major_count);
if ($result) $query = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo "<b>Number of majors:</b> ";
print_r($query[0]['COUNT(Major)']);

echo"<br>";
echo"<br>";

$sql_avg_age = 'SELECT AVG(Age) FROM students;';
$result = mysqli_query($conn, $sql_avg_age);
if ($result) $query = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo "<b>Average student age:</b> ";
print_r($query[0]['AVG(Age)']);
echo'<br>';
$sql_max_age = 'SELECT MAX(Age) FROM students;';
$result = mysqli_query($conn, $sql_max_age);
if ($result) $query = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo "<b>Oldest student:</b> ";
print_r($query[0]['MAX(Age)']);
echo'<br>';
$sql_min_age = 'SELECT MIN(Age) FROM students;';
$result = mysqli_query($conn, $sql_min_age);
if ($result) $query = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo "<b>Youngest student:</b> ";
print_r($query[0]['MIN(Age)']);

echo"<br>";
echo"<br>";

$sql_insert = 'INSERT INTO students VALUES (7, "PHP NAME", "09872831", "PHP MAJOR", "PHP CLASS", "PHP@sau.edu", "Female", 50, "534242342");';
if ($conn->query($sql_insert) === true) {
    echo "<b>Record Entered Successfully:</b> " . $sql_insert;
	echo '<br>'; 
	$q = mysqli_fetch_all(mysqli_query($conn, 'SELECT * FROM students WHERE ID=7', MYSQLI_ASSOC));
	print_r($q[0]);
} else {
    echo "<b>Error Entering Record:</b> " . $conn->error;
}
echo'<br>';
echo'<br>';
$sql_delete = 'DELETE FROM students WHERE ID=7;';
if ($conn->query($sql_delete) === true) {
    echo "<b>Record Deleted Successfully:</b> " . $sql_delete;
	echo '<br>'; 
	$q = mysqli_fetch_all(mysqli_query($conn, 'SELECT * FROM students WHERE ID=7', MYSQLI_ASSOC));
	print_r($q);
} else {
    echo "<b>Error Deleting Record:</b> " . $conn->error;
}

echo'<br>';
echo'<br>';

$sql_update_phone = 'UPDATE students SET Phone="321-654-0987" WHERE Name="John Doe";';
if ($conn->query($sql_update_phone) === true) {
    echo "<b>Phone Number Updated Successfully:</b> ";
	$q = mysqli_fetch_all(mysqli_query($conn, 'SELECT Phone FROM students WHERE Name="John Doe";', MYSQLI_ASSOC));
	print_r($q[0][0]);
} else {
    echo "<b>Error Updating Number:</b> " . $conn->error;
}

echo"<br>";
echo"<br>";
$conn->close();
echo "-";
?>

</body>
</html>