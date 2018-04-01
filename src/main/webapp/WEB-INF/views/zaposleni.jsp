<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Zaposleni - zahtev za slobodne dane</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
    <script>
        $(document).ready(function(){
            $(".btn1").click(function(){
                $(".container").fadeOut(function() {
                    $(".success").fadeIn()
                });
            });
            $(".btn2").click(function(){
                $(".container").fadeOut(function() {
                    $(".negative").fadeIn()
                });
            });
        });
    </script>
    <style>
        /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
        .row.content {height: 1500px}

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
            margin-top: 6.5%;
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
            .modal {
                width: 50%;
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
                <li><a href="">Osnovni podaci</a></li>
                <li class="active"><a href="#section2">Slobodno</a></li>
                <li><a href="#section3">Obuka</a></li>
                <li><a href="#section3">Otkaz</a></li>
            </ul><br>

        </div>

        <div class="col-sm-9">

            <div class="col-sm-12 buttonDan">
                <button type="button" class="btn btn-info btn-md" id="datetimepicker123">Raspored</button>
                <script type="text/javascript">
                    $(function () {
                        $('#datetimepicker123').datepicker();
                    });
                </script>
            </div>

            <div class="col-sm-12" style="padding-top: 2%;">

                <div class="container" style="width: 50%; margin: 0%; padding: 0%;">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <label class="form-control-label">Zaposleni ime i prezime traži slobodne dane</label>
                                </div>
                                <div class="col-sm-12">
                                    <label class="form-control-label">Povod:</label>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-control-label">Početni datum:</label>

                                </div>
                                <div class="col-sm-6">
                                    <label class="form-control-label">Zaključni datum:</label>
                                </div>
                                <div class="col-sm-6">
                                    <div class="col-sm-3" style="padding: 3%;">
                                        <button type="button" class="btn1 btn-info btn-sm"><span class="glyphicon glyphicon-ok"></span></button>

                                    </div>

                                    <div class="col-sm-3" style="padding: 3%;">
                                        <button type="button" class="btn2 btn-info btn-sm"><span class="glyphicon glyphicon-remove"></span></button>
                                    </div>
                                    <div class="col-sm-3" style="padding: 3%;">
                                        <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span></button>
                                        <div id="myModal" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div style="overflow:hidden;">
                                                            <div class="form-group">
                                                                <div class="row">
                                                                    <div class="col-md-8">
                                                                        <div id="datetimepicker11"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <script type="text/javascript">
                                                                $(function () {
                                                                    $('#datetimepicker11').datepicker({
                                                                        inline: true,
                                                                        sideBySide: true
                                                                    });
                                                                });
                                                            </script>
                                                        </div>

                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Zatvori</button>
                                                        <button type="button" class="btn btn-info" data-dismiss="modal">Sacuvaj</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="col-sm-3" style="padding: 3%;">
                                        <button type="button" class="btn1 btn-info btn-sm"><span class="glyphicon glyphicon-ok"></span></button>
                                    </div>
                                    <div class="col-sm-3" style="padding: 3%;">
                                        <button type="button" class="btn2 btn-info btn-sm"><span class="glyphicon glyphicon-remove"></span></button>
                                    </div>
                                    <div class="col-sm-3" style="padding: 3%;">
                                        <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span></button>
                                        <div id="myModal" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div style="overflow:hidden;">
                                                            <div class="form-group">
                                                                <div class="row">
                                                                    <div class="col-md-8">
                                                                        <div id="datetimepicker12"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <script type="text/javascript">
                                                                $(function () {
                                                                    $('#datetimepicker12').datepicker({
                                                                        inline: true,
                                                                        sideBySide: true
                                                                    });
                                                                });
                                                            </script>
                                                        </div>

                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Zatvori</button>
                                                        <button type="button" class="btn btn-info" data-dismiss="modal">Sacuvaj</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="success" style="display: none;">Odobreno</div>
                <div class="negative" style="display: none;">Zahtev nije odobren</div>
            </div>

        </div>
    </div>

</div>

<footer class="container-fluid">
    <p>HRIS created by Marina Damnjanović</p>
</footer>

</body>

</html>
