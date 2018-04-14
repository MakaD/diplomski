<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <title>Zaposleni - zahtevi za slobodne dane</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>

    <style>
        /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
        .row.content {height: 600px}

        /* Set gray background color and 100% height */
        .sidenav {
            background-color: #f1f1f1;
            height: 100%;
            padding-top: 2%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }
        .buttonDan {
            margin-top: 3%;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .buttonDan {
                margin-top: 0%;
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
                <li class="active"><a href="zaposleni.html">Podaci</a></li>
                <li>
                    <ul class="sections"><a href="#">Lični podaci</a></ul>
                    <ul><a href="#">Ugovor</a></ul>
                    <ul><a href="#">Zarada</a></ul>
                </li>
                <li><a href="#">Projekti</a></li>
                <li><a href="#">Odmor</a></li>
                <li><a href="##">Obaveštenja</a></li>
            </ul><br>

        </div>

        <div class="col-sm-9">
            <div class="col-sm-6 buttonDan">
                <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">Zatraži slobodan dan</button>
            </div>

            <form action="<spring:url value="/zaposleni/"/>" method="POST">
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Zahtev</h4>
                        </div>
                        <div class="modal-body">

                        <% String success = (String) request.getAttribute("successMsg");%>
                        <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
                            <div class="row">
                                <div class="col-sm-6">
                                    <label class="form-control-label">Povod:</label>
                                    <input type="text" class="form-control"  name="povod">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <label class="form-control-label">Datum od:</label>
                                    <div class="form-group">
                                        <div class='input-group date' id='datetimepicker1'>
                                            <input type='text' class="form-control" name="datumOd"/>
                                            <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                                        </div>
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    $(function () {
                                        $('#datetimepicker1').datepicker();
                                    });
                                </script>
                                <div class="col-sm-6">
                                    <label class="form-control-label">Datum do:</label>
                                    <div class="form-group">
                                        <div class='input-group date' id='datetimepicker2'>
                                            <input type='text' class="form-control" name="datumDo" />
                                            <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                     </span>
                                        </div>
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    $(function () {
                                        $('#datetimepicker2').datepicker();
                                    });
                                </script>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Zatvori</button>
                            <input type="submit" class="btn btn-info" value="Pošalji" />
                        </div>
                    </div>
                </div>
            </div>
            </form>

        </div>
    </div>
</div>

<a href="<c:url value='/logout' />">Logout</a>

<footer class="container-fluid">
    <p>HRIS created by Marina Damnjanović</p>
</footer>

</body>

</html>
