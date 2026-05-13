import './App.css';

import { useState } from "react";
import ProgramList from "./components/ProgramList";
import ProgramDetail from "./components/ProgramDetail";
import ProgramForm from "./components/ProgramForm";

function App() {
  const [selectedId, setSelectedId] = useState(null);

  return (
    <div style={{ display: "flex", gap: "2rem", padding: "2rem" }}>
      {/* Left column: List */}
      <div>
        <h2>Programs</h2>
        <ProgramList onSelect={setSelectedId} />
      </div>

      {/* Middle column: Details */}
      <div>
        <h2>Details</h2>
        <ProgramDetail id={selectedId} />
      </div>

      {/* Right column: Create/Update */}
      <div>
        <h2>{selectedId ? "Edit Program" : "Create Program"}</h2>
        <ProgramForm
          stateId={1}                 // You can change this later
          programId={selectedId}
          onSaved={() => setSelectedId(null)}
        />
      </div>
    </div>
  );
}

export default App;

