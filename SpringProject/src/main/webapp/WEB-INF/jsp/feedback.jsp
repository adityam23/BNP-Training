<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">



<!DOCTYPE html>
<html>
<head>
<style>
.center {
	margin: 0;
	position: absolute;
	left: 50%;
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}
</style>
<meta charset="ISO-8859-1">
<title>Feedback Form</title>
</head>
<body>
	<div class="container">
		<form:form action="/add-feedback" method="post"
			modelAttribute="feedback">
			<form:hidden path="feedbackId" />
			<div class="row">
				<fieldset class="form-group">
					<div class="col-25">
						<form:label path="userName">Please enter your name :</form:label>
					</div>
					<div class="col-75">
						<form:input path="userName" type="text" class="form-control"
							required="required" />
						<form:errors path="userName" cssClass="text-warning" />
					</div>
				</fieldset>
			</div>
			<div class="row">
				<fieldset class="form-group">
					<div class="col-25">
						<form:label path="email">Please enter your email :</form:label>
					</div>
					<form:input path="email" type="email" class="form-control"
						required="required" />
					<form:errors path="email" cssClass="text-warning" />
				</fieldset>
			</div>
			<div class="row">
				<fieldset class="form-group">
					<div class="col-25">
						<form:label path="feedbackText">Please enter your feedback :</form:label>
					</div>
					<div class="col-75">
						<form:textarea path="feedbackText" type="email"
							class="form-control" required="required" />
						<form:errors path="feedbackText" cssClass="text-warning" />
					</div>
				</fieldset>
			</div>
			<div class="row">
				<fieldset class="form-group">
					<div class="col-25">
						<form:label path="rating">Please enter your rating of the experience :
						</form:label>
					</div>
					<label class="radio-inline">
					<form:radiobutton path="rating" value="very bad"
						required="required" />
					Very Bad
					</label>
					<label class="radio-inline">
					<form:radiobutton path="rating" value="bad" required="required" />
					Bad
					</label>
					<label class="radio-inline">
					<form:radiobutton path="rating" value="okay" required="required" />
					Okay
					</label>
					<label class="radio-inline">
					<form:radiobutton path="rating" value="good" required="required" />
					Good
					</label>
					<label class="radio-inline">
					<form:radiobutton path="rating" value="very good"
						required="required" />
					Very Good
					</label>
					<form:errors path="rating" cssClass="text-warning" />
				</fieldset>
			</div>
			<div class="row">
				<button type="submit" class="center btn btn-success btn-lg">Add</button>
			</div>
		</form:form>
	</div>
</body>
</html>