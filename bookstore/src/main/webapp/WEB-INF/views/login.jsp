<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<div>${exception.message}</div>
	<form method="POST" action="${action}">
		<label>Username</label><input type="text" name="username" value="${account.username}" />
		<br />
		<label>Password</label><input type="password" name="password" />
		<br />
		<input type="submit" value="Login">
	</form>
</body>
</html>