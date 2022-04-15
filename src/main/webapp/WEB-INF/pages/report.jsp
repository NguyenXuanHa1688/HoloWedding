<%-- 
    Document   : about
    Created on : Apr 14, 2022, 3:59:38 PM
    Author     : billg
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <!-- REPORT -->
    <br>
    <br>
    <br>
    <br>
    <br>

    <h1 class="text-center text-info">Popular parties</h1>

    <div class="row" style="margin: 40px auto 50px auto; width: 80%">
        <div class="col-md-5">
            <table class="table">
                <h4>Table</h4>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>BOOKED</th>
                </tr>
                <c:forEach items="${chartdata}" var="entry"  varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${entry.key}</td>
                        <td>${entry.value}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <div class="col-md-7">
            <h4>Chart</h4>
            <canvas id="mychart"></canvas>
        </div>
    </div>

    <script>
        const ctx = document.getElementById('mychart').getContext('2d');
        const myChart = new Chart(ctx, {
        type: 'bar',
                data: {
                labels: [
        <c:forEach items="${chartdata}" var="entry"  varStatus="loop">
                '${entry.key}',
        </c:forEach>
                ],
                        datasets: [{
                        label: '# of Votes',
                                data: [
        <c:forEach items="${chartdata}" var="entry"  varStatus="loop">
            ${entry.value},
        </c:forEach>
                                ],
                                backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                ],
                                borderColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                ],
                                borderWidth: 1
                        }]
                },
                options: {
                scales: {
                y: {
                beginAtZero: true
                }
                }
                }
        });
    </script>

