import logo from "./aucalogo.png";
const Nav = () => {
  return (
    <div>
      <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="#">
          <img
            src={logo}
            width=""
            height=""
            class="d-inline-block align-top"
            alt=""
          />
        </a>
      </nav>
      <nav class="navbar navbar-light" style={{ backgroundColor: "#e3f2fd" }}>
        <nav class="navbar navbar-expand-lg navbar-light ">
          <a class="navbar-brand" href="/students">
            Students
          </a>
          <a class="navbar-brand" href="/registration">
            Register Student
          </a>
          <a class="navbar-brand" href="/courses">
            Course
          </a>
          <a class="navbar-brand" href="/semester">
            Semester
          </a>
          <a class="navbar-brand" href="#">
            Register Student
          </a>
          <a class="navbar-brand" href="#">
            Add Semester
          </a>
        </nav>
      </nav>
    </div>
  );
};

export default Nav;
