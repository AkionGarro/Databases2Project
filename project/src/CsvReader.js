import { useState } from "react";
import "./CsvReader.css";

export default function CsvReader() {
  const [csvFile, setCsvFile] = useState();
  const [csvArray, setCsvArray] = useState([]);

  const processCSV = (str, delim = ",") => {
    const headers = str.slice(0, str.indexOf("\n")).split(delim);
    const rows = str.slice(str.indexOf("\n") + 1).split("\n");
    console.log(headers);
    const newArray = rows.map((row) => {
      const values = row.split(delim);
      const eachObject = headers.reduce((obj, header, i) => {
        obj[header] = values[i];
        return obj;
      }, {});
      return eachObject;
    });
    //setCsvArray(newArray);
  };

  const submit = () => {
    const file = csvFile;
    const reader = new FileReader();
    reader.onload = function (e) {
      const text = e.target.result;

      processCSV(text);
    };
    reader.readAsText(file);
  };

  return (
    <form id="csv-form" className="content">
      <input
        type="file"
        accept=".csv"
        id="csvFile"
        onChange={(e) => {
          setCsvFile(e.target.files[0]);
        }}
      ></input>

      <br />
      <button
        className="btn btn-primary"
        onClick={(e) => {
          e.preventDefault();
          if (csvFile) submit();
        }}
      >
        submit
      </button>
      <br />
      <br />
      {csvArray.length > 0 ? null : null}
    </form>
  );
}
