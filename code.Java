document.addEventListener("DOMContentLoaded", () => {
  const button = document.getElementById("convert-btn");
  const input = document.getElementById("number");
  const output = document.getElementById("output");

  button.addEventListener("click", () => {
    let number = parseInt(input.value.trim(), 10); 

    function isValid(number) {
      if (isNaN(number)) {
        output.innerHTML = "Please enter a valid number";
        return false;
      } else if (number < 1) {
        output.innerHTML = "Please enter a number greater than or equal to 1";
        return false;
      } else if (number > 3999) {
        output.innerHTML = "Please enter a number less than or equal to 3999";
        return false;
      }
      return true;
    }

    if (!isValid(number)) {
      return; 
    }

    const values = [
      { value: 1000, numeral: "M" },
      { value: 900, numeral: "CM" },
      { value: 500, numeral: "D" },
      { value: 400, numeral: "CD" },
      { value: 100, numeral: "C" },
      { value: 90, numeral: "XC" },
      { value: 50, numeral: "L" },
      { value: 40, numeral: "XL" },
      { value: 10, numeral: "X" },
      { value: 9, numeral: "IX" },
      { value: 5, numeral: "V" },
      { value: 4, numeral: "IV" },
      { value: 1, numeral: "I" }
    ];

    let result = "";
    for (const { value, numeral } of values) {
      while (number >= value) {
        result += numeral;
        number -= value;
      }
    }

    output.innerHTML = result;
  });
});
