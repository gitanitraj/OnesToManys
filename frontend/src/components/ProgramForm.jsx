import { useState, useEffect } from "react";
import { fetchJSON } from "./api";

export default function ProgramForm({ stateId, programId, onSaved }) {
  const [form, setForm] = useState({
    programName: "",
    description: "",
    interestRate: "",
    maxLoanAmount: "",
    termYears: "",
    active: true
  });

  // Load existing program for editing
  useEffect(() => {
    if (!programId) return;
    fetchJSON(`/api/mortgage-programs/${programId}`)
      .then(data => setForm(data))
      .catch(console.error);
  }, [programId]);

  function handleChange(e) {
    const { name, value, type, checked } = e.target;
    setForm(f => ({
      ...f,
      [name]: type === "checkbox" ? checked : value
    }));
  }

  async function handleSubmit(e) {
    e.preventDefault();

    const url = programId
      ? `/api/mortgage-programs/${programId}`
      : `/api/mortgage-programs/state/${stateId}`;

    const method = programId ? "PUT" : "POST";

    const saved = await fetchJSON(url, {
      method,
      body: JSON.stringify(form)
    });

    onSaved(saved);
  }

  return (
    <form onSubmit={handleSubmit}>
      <h3>{programId ? "Edit Program" : "Create Program"}</h3>

      <input
        name="programName"
        value={form.programName}
        onChange={handleChange}
        placeholder="Program Name"
      />

      <textarea
        name="description"
        value={form.description}
        onChange={handleChange}
        placeholder="Description"
      />

      <input
        name="interestRate"
        type="number"
        step="0.01"
        value={form.interestRate}
        onChange={handleChange}
        placeholder="Interest Rate"
      />

      <input
        name="maxLoanAmount"
        type="number"
        value={form.maxLoanAmount}
        onChange={handleChange}
        placeholder="Max Loan Amount"
      />

      <input
        name="termYears"
        type="number"
        value={form.termYears}
        onChange={handleChange}
        placeholder="Term (years)"
      />

      <label>
        <input
          type="checkbox"
          name="active"
          checked={form.active}
          onChange={handleChange}
        />
        Active
      </label>

      <button type="submit">Save</button>
    </form>
  );
}
