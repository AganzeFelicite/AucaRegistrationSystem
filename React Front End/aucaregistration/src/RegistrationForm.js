import useFetch from "./useFetch";
import { useState } from "react";
const RegistrationForm = () => {
  const semUrl = "http://127.0.0.1:8080/semester/all";
  const acadUrl = "http://127.0.0.1:8080/academicUnit/all";
  const stdUrl = "http://127.0.0.1:8080/student/all";

  const [studId, setStudId] = useState("");
  const [acadId, setAcadId] = useState("");
  const [semId, setSemId] = useState("");
  const [regStatus, setRegStatus] = useState("");

  const [loading, setLoading] = useState(null);

  const { data: sem, isPending: semLoad, error: semErro } = useFetch(semUrl);
  const {
    data: acad,
    isPending: acadLoad,
    error: acadErro,
  } = useFetch(acadUrl);
  const { data: std, isPending: stdLoad, error: stdErro } = useFetch(stdUrl);
  console.log();

  const formHandler = (e) => {
    e.preventDefault();
    setLoading(true);

    setTimeout(
      () => {
        fetch("http://127.0.0.1:8080/Registration/newRegistration", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            semId: parseInt(semId),
            regStatus,
            acadId,
            studId: parseInt(studId),
          }),
        })
          .then(() => {
            setLoading(false);
          })
          .catch((err) => {
            console.log(err);
          });
      },

      2000
    );
  };

  return (
    <div className="container mt-5">
      <h4></h4>
      <form onSubmit={formHandler}>
        <div className="row">
          <div className="col">
            <select
              className="form-select form-control"
              aria-label="Default select example"
              onChange={(e) => setStudId(e.target.value)}
            >
              <option selected>Select A Student</option>
              {std &&
                std.map((data) => (
                  <option value={data.regNo} key={data.regNo}>
                    {data.firstName + " " + data.lastName}
                  </option>
                ))}
              {stdLoad && <p>loading ...</p>}
              {stdErro && <p>failed to fetch data</p>}
            </select>
          </div>
          <div className="col">
            <select
              className="form-select form-control"
              aria-label="Default select example"
              onChange={(e) => setSemId(e.target.value)}
            >
              <option selected>Select A Semester</option>
              {sem &&
                sem.map((data) => (
                  <option value={data.semId} key={data.semId}>
                    {data.name}
                  </option>
                ))}
              {semLoad && <p>loading ...</p>}
              {semErro && <p>failed to fetch data</p>}
            </select>
          </div>
          <div className="col">
            <select
              className="form-select form-control"
              aria-label="Default select example"
              onChange={(e) => setAcadId(e.target.value)}
            >
              <option selected>Select An Academic Unit</option>
              {acad &&
                acad.map((data) => (
                  <option value={data.code} key={data.code}>
                    {data.name}
                  </option>
                ))}
              {acadLoad && <p>loading ...</p>}
              {acadErro && <p>failed to fetch data</p>}
            </select>
          </div>
          <div className="col">
            <select
              className="form-select form-control"
              aria-label="Default select example"
              onChange={(e) => setRegStatus(e.target.value)}
            >
              <option selected>Select A Status</option>
              <option value="PENDING">PENDING</option>
              <option value="ADMITTED">ADMITTED</option>
              <option value="REJECTED">REJECTED</option>
            </select>
          </div>
          {!loading && (
            <button type="submit" className="btn btn-lg btn-primary">
              Submit
            </button>
          )}
          {loading && (
            <button type="submit" className="btn btn-lg btn-primary">
              registering ....
            </button>
          )}
        </div>
      </form>
    </div>
  );
};

export default RegistrationForm;
