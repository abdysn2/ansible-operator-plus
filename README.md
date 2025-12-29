# AnsibleOperator+

AnsibleOperator+ is an **offline-first, IDE-agnostic JetBrains plugin** designed to provide a first-class editing experience for **Ansible Operator projects**.  
Its long-term goal is to make authoring, navigating, validating, and refactoring Ansible Operator code as productive and safe as working with a fully supported programming language—directly inside JetBrains IDEs.

The plugin is built on **IntelliJ Platform APIs only**, avoiding IDE-specific dependencies (e.g. GoLand-only APIs), ensuring compatibility with **GoLand, PyCharm, and IntelliJ IDEA**.

---

## Project Vision

Modern Ansible Operator projects combine:

- YAML playbooks and roles
- Embedded Jinja2 templating
- Kubernetes CRDs and `watches.yaml`
- Large offline or air-gapped environments

Yet today, developers lack IDE tooling that understands **Ansible semantics**, **operator context**, and **offline constraints**.

**AnsibleOperator+ aims to:**

- Treat Ansible Operator code as a *first-class citizen* in JetBrains IDEs
- Provide **smart, context-aware assistance** (completion, navigation, validation)
- Work **fully offline**, with no required internet access
- Remain **IDE-agnostic**, portable across JetBrains products
- Scale from simple playbooks to large production operators
- Enable safe refactoring and long-term maintainability

The end vision is an IDE experience where:
> *Writing Ansible Operators feels guided, predictable, and safe — not trial-and-error.*

---

## High-Level Roadmap

Development is structured into **incremental milestones**, each delivering usable value while laying foundations for more advanced capabilities.

### Roadmap Principles

- **Offline-first**: All core features work without internet access
- **Incremental delivery**: Each milestone is independently useful
- **Extensible architecture**: Later milestones build cleanly on earlier ones
- **IDE-agnostic**: No GoLand-only or Python-only assumptions

### Roadmap Overview

1. **Editor Foundations**  
   Solid YAML + Jinja editing, offline data cache, basic autocomplete

2. **MVP (v1.0)**  
   Context-aware intelligence: variables, roles, navigation, docs, validation

3. **High-Priority Enhancements**  
   Refactoring, snippets, linting, developer-experience improvements

4. **Optional / Advanced Features**  
   Execution, visualization, Helm support, visual inlays, cross-IDE polish

---

## Milestone List

### Milestone 1 — Editor Foundation

**Goal:** Establish a robust base for Ansible YAML + Jinja editing.

Key outcomes:
- IDE-agnostic plugin scaffold
- YAML + embedded Jinja2 support
- Auto-closing Jinja braces
- Offline cache of Ansible module metadata
- Basic keyword & module name autocompletion
- No false syntax errors for valid Ansible files

This milestone ensures the plugin is *usable from day one*.

---

### Milestone 2 — Core Features Complete (MVP v1.0)

**Goal:** Make the plugin context-aware and production-ready.

Key outcomes:
- Background indexing of roles, variables, CRDs, and `watches.yaml`
- Smart, context-aware autocompletion
- Go-to-definition for roles, variables, and includes
- Offline inline documentation (module docs, role info, variables)
- Basic Ansible-specific validation (unknown params, undefined vars)
- Marketplace-ready MVP release

This milestone delivers the **first public release**.

---

### Milestone 3 — High-Priority Enhancements

**Goal:** Improve developer productivity and code safety.

Key outcomes:
- Safe refactoring (rename variables & roles, find usages)
- Live templates and code snippets
- Role scaffolding actions
- Optional offline linting integration
- Improved indexing for large projects

This milestone focuses on **long-term maintainability**.

---

### Milestone 4 — Optional Features (Nice-to-Have Enhancements)

**Goal:** Add advanced and visual tooling without bloating the core.

Key outcomes:
- Helm template recognition and highlighting
- Optional playbook execution & dry-run integration
- Visual inlay hints for variables
- Project overview & dependency visualization
- Cross-IDE polish and expanded compatibility
- Preparation for a major feature release (v2.x)

All features in this milestone are **opt-in and modular**.

---

## Status

🚧 **Active Development**  
The project is evolving milestone by milestone, with architecture designed to support future expansion and collaboration.

---

## License

License details will be added as the project approaches public release.

---

## Contributing

Contribution guidelines will be published once the core architecture stabilizes.  
The codebase is intentionally modular to support future collaborators.

---

**AnsibleOperator+**  
*Offline-first intelligence for Ansible Operators inside JetBrains IDEs.*

