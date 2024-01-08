import { svg, dot } from "./svgGenerator.js"

svg(0)

const x = document.getElementById('x')
const xError = document.getElementById('xError')

const y = document.getElementById('y')
const yError = document.getElementById('yError')

const buttons = document.getElementsByName('r')
const rError = document.getElementById('rError')

let rValue = null

async function submit() {

    const xValue = x.value.replaceAll(",", ".")
    const yValue = y.value.replaceAll(",", ".")
    const xStatus = checkXY(xValue, xError)
    const yStatus = checkXY(yValue, yError)
    const rStatus = checkButtons()

    if (xStatus && yStatus && rStatus) {
        let point = new FormData()
        point.append('x', xValue)
        point.append('y', yValue)
        point.append('r', rValue)

        await fetch('controller', {
            method: 'POST',
            body: point
        });

        let response = await fetch('table.jsp', {method : 'GET'});
        let tableText = await response.text();
        document.querySelector("#table-container").innerHTML = tableText;
    }
}

function checkXY(value, error) {
    if (!(value)) {
        error.textContent = "Поле не может быть пустым"
        return false
    } else {
        if (isNaN(value) || value <= -5 || value >= 5) {
            error.textContent = "Введите число от -5 до 5"
            return false
        } else {
            error.textContent = ""
            return true
        }
    }
}

function setR(button) {
    for (let b of buttons){
        b.classList.remove("clicked")
    }
    button.classList.add("clicked")
    rValue = parseFloat(button.value)
    svg(rValue);
}

function checkButtons() {
    if (rValue == null) {
        rError.textContent = "Выберите радиус области"
        return false;
    }
    rError.textContent = ""
    return true;
}

function drawDot(e){
    let rect = document.getElementById("task-container").getBoundingClientRect();
    let clickedX = e.clientX - rect.left;
    let clickedY = e.clientY - rect.top;
    x.value = (clickedX / 30 - 5).toFixed(2);
    y.value = (5 - clickedY / 30).toFixed(2);
    dot(clickedX, clickedY);
    submit();
}

window.setR = setR
window.submit = submit
window.drawDot = drawDot
