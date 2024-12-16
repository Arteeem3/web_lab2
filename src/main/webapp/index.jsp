<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LABA</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>

<header>
    <h1 class="credits">Соколов Артём Олегович</h1>
    <h1 class="group">P3218 409599</h1>
    <h1 class="var">8345</h1>
</header>


<main>
    <div class="variables">
        <p>Переменные</p>
        <div class="form" id="form" >

            <label for="xSelection">
                <p>X</p>
                <div name = "xSelection" id="xSelection">
                <input type="button" value="-4" class = "xButtons"></input>
                <input type="button" value="-3" class = "xButtons"></input>
                <input type="button" value="-2" class = "xButtons"></input>
                <input type="button" value="-1" class = "xButtons"></input>
                <input type="button" value="0" class = "xButtons"></input>
                <input type="button" value="1" class = "xButtons"></input>
                <input type="button" value="2" class = "xButtons"></input>
                <input type="button" value="3" class = "xButtons"></input>
                <input type="button" value="4" class = "xButtons"></input>
                </div>
            </label>
            <div>
                <label for="ySelection">
                    <p>Y</p>
                    <input type="text" name="y" id="ySelection" required placeholder="-5...5">
                </label>
            </div>
            <div class="thirdColumn">
                <p>R</p>
                <label for="r1"><input type="radio" value="1" id="r1" class="radiobutton" name="Radius">1</label>
                <label for="r2"><input type="radio" value="2" id="r2" class="radiobutton" name="Radius">2</label>
                <label for="r3"><input type="radio" value="3" id="r3" class="radiobutton" name="Radius">3</label>
                <label for="r4"><input type="radio" value="4" id="r4" class="radiobutton" name="Radius">4</label>
                <label for="r5"><input type="radio" value="5" id="r5" class="radiobutton" name="Radius">5</label>
            </div>
            <button type="button" onclick="submit()" >Отправить</button>
        </div>
    </div>

    <div class="canvasContainer">
        <p>График</p>
        <canvas width="400" height="400" id="canvas"></canvas>
    </div>
</main>
<footer>
    <div class = 'tableContainer'>
        <jsp:include page="result.jsp"></jsp:include>
    </div>
    <status class="status"></status>
</footer>
<script src="canvas.js"></script>
<script src="script.js"></script>
</body>
</html>