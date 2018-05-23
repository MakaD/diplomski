<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>HR menadžer - zahtev za slobodne dane</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
    <script>
        $(document).ready(function(){
            $(".btnSave").click(function(){
                    if ($("#mySelectBox option:selected").text() == "Odobri zahtev")
                        $("#cont").fadeOut(function() {
                            $("#success").fadeIn()
                        });
                    else
                        $("#cont").fadeOut(function() {
                            $("#negative").fadeIn()
                        });
            });
        });
    </script>
    <style>
        /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
        .row.content {height: 600px}

        /* Set gray background color and 100% height */
        .sidenav {
            background-color: #f1f1f1;
            height: 100%;
            padding-top: 2%;
        }
        .title {
            margin-top: 4%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height: auto;}
        }

    </style>
</head>

<body>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#">Osnovni podaci</a></li>
                <li class="active"><a href="#">Slobodno</a></li>
                <li><a href="#">Obuka</a></li>
                <li><a href="#">Otkaz</a></li>
            </ul><br>

        </div>

        <div class="col-sm-9">

            <div class="col-sm-12">
                <h3 class="title text-primary">Zahtevi za slobodnim danima</h3>
            </div>

            <div class="col-sm-12" style="padding-top: 2%;">
            <c:forEach items="${zahtevi}" var="zahtev">

                <form:form method="POST" action="/menadzer" modelAttribute="zahtev">
                <input type="hidden" class="form-control" name="id" value="${zahtev.id}" />

                <div class="container" id="cont" style="width: 50%; margin: 0%; padding: 0%;">
                    <div class="panel panel-default" >
                        <div class="panel-body">
                            <div class="row">

                                <div class="col-sm-12">
                                    <label class="form-control-label">Zaposleni: Ivan Nikolić</label>
                                </div>
                                <div class="col-sm-12">
                                    <label class="form-control-label">Povod: ${zahtev.povod}</label>
                                </div>
                                <div class="col-sm-6">
                                        <label class="form-control-label">Datum od:</label>
                                        <div class="form-group">
                                            <div class='datetimepicker1 input-group date' id=''>
                                                <input type='text' class="form-control" name="datumOd" value="${zahtev.datumOd}"/>
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
                                    <script type="text/javascript">
                                        $(function () {
                                            $('.datetimepicker1').datepicker();
                                        });
                                    </script>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-control-label">Datum do:</label>
                                    <div class="form-group">
                                        <div class='datetimepicker2 input-group date' id=''>
                                            <input type='text' class="form-control" name="datumDo" value=" ${zahtev.datumDo}"/>
                                            <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                        </div>
                                    </div>
                                    <script type="text/javascript">
                                        $(function () {
                                            $('.datetimepicker2').datepicker();
                                        });
                                    </script>
                                </div>

                                <div class="col-sm-12">
                                    <div class="form-group ">
                                        <select class="form-control" id="mySelectBox">
                                            <option>Odobri zahtev</option>
                                            <option>Odbij zahtev</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-sm-12">
                                    <input type="submit" class="btnSave btn-sm btn-info btn-create" value="Sačuvaj"/>

                                </div>

                            </div>
                        </div>

                    </div>
                </div>

                <div class="success" id="success" style="display: none;"><h5 class="text-muted">Zahtev je odobren</h5></div>
                <div class="negative" id="negative" style="display: none;"><h5 class="text-muted">Zahtev nije odobren</h5></div>

                </form:form>

            </c:forEach>
            </div>

        </div>
    </div>

</div>

<a href="<c:url value='/logout' />">Logout</a>

<footer class="container-fluid">
    <p>HRIS created by Marina Damnjanović</p>
</footer>

</body>

</html>
