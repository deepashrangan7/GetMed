
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

    <title>GetMed</title>
    <style>
        body {
            font-family: Arial;
            color: white;
        }

        .split {
            height: 100%;
            width: 50%;
            position: fixed;
            z-index: 1;
            top: 0;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .left {
            left: 0;
            background-color: #111;
                                                
                                                
        }

        .right {
            right: 0;
            background-color: aliceblue;
        }

        .centered {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
                                                
                                                
                                                
        }
                                .clr{
                                   font-family:harlow solid;
                                   text-align:left;
                                   font-size:50px;
                                   color:black;
                                   
                                  
                                }

        .centered img {
            width: 150px;
            border-radius: 50%;
        }
    </style>
        <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
  <nav class="navbar navbar-expand-lg fixed-top bg-dark">

            <img src="logo2.png" class="rounded float-left" alt="Logo" style="width:5%;height: 5%;">
            <a class="navbar-brand text-light float-left" href="#">
                GetMed</a>
              

        </nav>
        <div class="split left" style="background:rgb(258,215,2384)">
            <div class="centered">
                                                                
                                                <p class="clr">Medicine is a science of uncertainty and an art of probability!!
                                                </p>
                                                
                                                
            </div>
        </div>

        <div class="split right" style="background-color:white">
            <div class="centered">

                <div class="container" style="width:120%;">
                    <br /><br />
                    <h3 style="padding-bottom: 20%;color: black;">Who Are You?</h3>

                    <a class="btn btn-outline-dark btn-lg" href="/log/ad" role="button">Admin</a>
                    <br /><br /><br />
                    <a class="btn btn-outline-dark btn-lg" href="/log/us" role="button">&nbsp;User&nbsp;</a>
                    <br /><br />
                </div>

            </div>
        </div>

    </body>

    </html>


