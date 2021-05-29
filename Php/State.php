<?php
class State {
  // Properties
  private $stateID;
  private $stateName;

  // Methods
  function get_stateID() {
    return $this->stateID;
  }
  function set_stateName($stateName) {
    $this->stateName = $stateName;
  }
  function get_stateName() {
    return $this->stateName;
  }

}
?>