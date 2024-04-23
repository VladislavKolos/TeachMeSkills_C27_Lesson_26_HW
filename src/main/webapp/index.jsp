<!DOCTYPE html>
<html>
<head>
    <title>Book Download and Upload</title>
</head>
<body>
<h1>Book Download</h1>
<form action="book" method="get">
    <input type="file" name="bookFileName">
    <button type="submit">Download</button>
</form>

<h1>Book Load</h1>
<form action="load-book" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">Load</button>
</form>
</body>
</html>
