<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Лабораторная №2</title>
    <link rel="stylesheet" href="main_page.css">
    <script src="https://cdn.jsdelivr.net/npm/@svgdotjs/svg.js@3.0/dist/svg.min.js"></script>
    <script type="module" defer src="form_validation.js"></script>
    <script type="module" defer src="svgGenerator.js"></script>

</head>
<body>
<div id="background">
    <div id="mid">
        <div class="container" id="header">
            <p>Пальчикова Ева</p>
            <p>Группа P3230</p>
            <p>Вариант 512877</p>
        </div>
        <div class="container-big">
            <div class="container-small">
                <div class="container">
                    <p>Определить, попадает ли точка в заданную область:</p>
                    <div id="task-container" onclick="drawDot(event)"></div>
                </div>
            </div>
            <div class="container-small">
                <div class="container">
                    <div id="form">
                        <label class="input">X = <input id="x" type="text" name="x" maxlength="10"> <span
                                id="xError"></span></label>
                        <label class="input">Y = <input id="y" type="text" name="y" maxlength="10"> <span
                                id="yError"></span> </label>
                        <label class="input">R =
                            <input type="button" name="r" value="1" onclick="setR(this)">
                            <input type="button" name="r" value="2" onclick="setR(this)">
                            <input type="button" name="r" value="3" onclick="setR(this)">
                            <input type="button" name="r" value="4" onclick="setR(this)">
                            <input type="button" name="r" value="5" onclick="setR(this)">
                            <span id="rError"></span>
                        </label>
                        <input type="submit" value="Отправить" onclick="submit()">
                    </div>
                </div>
            </div>
        </div>
        <div class="container" id="table-container"></div>
    </div>
</div>
</body>
</html>