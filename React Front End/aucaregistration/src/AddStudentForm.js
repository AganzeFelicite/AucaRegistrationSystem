import { useState } from "react";

const AddStudentForm = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [isPending, setIsPending] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    setIsPending(true);

    const regNo = 124;
    const std = { regNo, firstName, lastName, dateOfBirth };

    setTimeout(() => {
      fetch("http://127.0.0.1:8080/student/saveStudent", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(std),
      }).then((res) => {
        console.log(res);
        setIsPending(false);
      });
    }, 2000);
  };

  return (
    <div className="container mt-5">
      <h4>Add New students</h4>
      <form onSubmit={handleSubmit}>
        <div className="row">
          <div className="col">
            <input
              type="text"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              className="form-control"
              placeholder="First name"
            />
          </div>
          <div className="col">
            <input
              type="text"
              className="form-control"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              placeholder="Last name"
            />
          </div>
          <div className="col">
            <input
              value={dateOfBirth}
              onChange={(e) => setDateOfBirth(e.target.value)}
              type="date"
              className="form-control"
              placeholder="Date Of Birth"
            />
          </div>
          {!isPending && (
            <button type="submit" className="btn btn-lg btn-primary">
              Submit
            </button>
          )}
          {isPending && <button disabled>saving ...</button>}
        </div>
      </form>
    </div>
  );
};

export default AddStudentForm;
