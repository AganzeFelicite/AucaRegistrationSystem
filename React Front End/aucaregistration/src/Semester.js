import SemesterList from "./SemesterList";
import useFetch from "./useFetch";

const Semester = () => {
  const url = "http://127.0.0.1:8080/semester/all";
  const { data, isPending, error } = useFetch(url);
  return (
    <div className="userDetails ">
      {/* <AddStudentForm /> */}
      <div className="home">
        {error && <div>{error} </div>}
        {isPending && <div> loading ...</div>}
        {data && <SemesterList data={data} />}
      </div>
    </div>
  );
};

export default Semester;
