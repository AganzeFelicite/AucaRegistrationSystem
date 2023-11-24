import AddStudentForm from "./AddStudentForm";
import StudentList from "./StudentList";
import useFetch from "./useFetch";

const Student = () => {
  const url = "http://127.0.0.1:8080/student/all";
  const { data, isPending, error } = useFetch(url);
  return (
    <div className="userDetails blog-preview">
      <AddStudentForm />
      <div className="home">
        {error && <div>{error} </div>}
        {isPending && <div> loading ...</div>}
        {data && <StudentList data={data} />}
      </div>
    </div>
  );
};

export default Student;
