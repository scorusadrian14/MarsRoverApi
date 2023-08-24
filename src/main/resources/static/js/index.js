let userId = getUrlParameter("userId");
if (userId == null || userId == "") {
  userId = localStorage.getItem("userId");
}
if (userId != null && userId != "") {
  localStorage.setItem("userId", userId);
  document.getElementById("userId").value = userId;
}

// Select from what Rover we get the photos

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

let roverDataType = document.getElementById("roverData").value;
let marsSol = document.getElementById("sol").value;

if (marsSol != null && marsSol > 0) {
  document.getElementById("sol").value = marsSol;
}

highlightButtonByRoverType(roverDataType);

function highlightButtonByRoverType(roverType) {
  document.getElementById(roverType).checked = true;
}
