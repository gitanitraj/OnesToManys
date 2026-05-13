import { useEffect, useState } from "react";
import { fetchJSON } from "./api";

export default function ProgramList({ stateId, onSelect }) {
  const [programs, setPrograms] = useState([]);

  useEffect(() => {
    const url = stateId
      ? `/api/mortgage-programs/state/${stateId}`
      : `/api/mortgage-programs`;

    fetchJSON(url).then(setPrograms).catch(console.error);
  }, [stateId]);

  return (
    <div>
      <h2>Mortgage Programs</h2>
      <ul>
        {programs.map(p => (
          <li key={p.id} onClick={() => onSelect(p.id)}>
            <strong>{p.programName}</strong> — {p.interestRate}%
          </li>
        ))}
      </ul>
    </div>
  );
}
