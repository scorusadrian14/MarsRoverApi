// Select from what Rover we get the pohotos

var roverButtons = document.querySelectorAll("input[name=btnradio]");

roverButtons.forEach((button) =>
  button.addEventListener("click", function () {
    const roverId = button.id;
    let apiData = document.getElementById("roverData");
    apiData.value = roverId;
    document.getElementById("formRover").submit();
  })
);

function getUrlParameter(name) {
  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)");
  var results = regex.exec(location.search);
  return results === null
    ? ""
    : decodeURIComponent(results[1].replace(/\+/g, " "));
}
let roverDataType = getUrlParameter("roverData");
let marsSol = getUrlParameter("sol");
document.getElementById("sol").value = marsSol;
highlightButtonByRoverType(roverDataType);

function highlightButtonByRoverType(roverType) {
  document.getElementById(roverType).checked = true;
}
