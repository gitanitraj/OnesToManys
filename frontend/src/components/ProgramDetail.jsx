import { useEffect, useState } from "react";
import { fetchJSON } from "./api";

export default function ProgramDetail({ id }) {
  const [program, setProgram] = useState(null);

  useEffect(() => {
    if (!id) return;
    fetchJSON(`/api/mortgage-programs/${id}`)
      .then(setProgram)
      .catch(console.error);
  }, [id]);

  if (!program) return <div>Select a program</div>;

  return (
    <div>
      <h2>{program.programName}</h2>
      <p><strong>State:</strong> {program.stateName}</p>
      <p><strong>Description:</strong> {program.description}</p>
      <p><strong>Interest Rate:</strong> {program.interestRate}%</p>
      <p><strong>Max Loan Amount:</strong> ${program.maxLoanAmount}</p>
      <p><strong>Term:</strong> {program.termYears} years</p>
      <p><strong>Active:</strong> {program.active ? "Yes" : "No"}</p>
    </div>
  );
}
