import React from "react";
import useFetch from "./useFetch";
import RegisteredList from "./RegisteredList";
const Registration = () => {
  const url = "http://127.0.0.1:8080/Registration/all";
  const { data, isPending, error } = useFetch(url);

  return (
    <div className="userDetails">
      <div className="home">
        {error && <div>{error} </div>}
        {isPending && <div> loading ...</div>}
        {data && <RegisteredList data={data} />}
      </div>
    </div>
  );
};

export default Registration;
